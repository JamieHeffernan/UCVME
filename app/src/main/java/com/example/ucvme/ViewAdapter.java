package com.example.ucvme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewAdapter extends FirebaseRecyclerAdapter<MainModel,ViewAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ViewAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    //called by RecyclerView to display the data at the specified position.
    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull MainModel model) {
        //holders for name,job and email
        holder.name.setText(model.getName());
        holder.job.setText(model.getJob());
        holder.email.setText(model.getEmail());

        //gets image
        Glide.with(holder.img.getContext())
                .load(model.getJurl())
                //placeholder image
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                //error image
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

        //edit button OnClickListener
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expands update menu
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                //update_popup EditTexts initialised
                EditText name = view.findViewById(R.id.nameText);
                EditText job = view.findViewById(R.id.jobText);
                EditText email = view.findViewById(R.id.emailText);
                EditText jurl = view.findViewById(R.id.imageTextUrl);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                //setTexts for given model
                name.setText(model.getName());
                job.setText(model.getJob());
                email.setText(model.getEmail());
                jurl.setText(model.getJurl());

                dialogPlus.show();

                //update button OnClickListener
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //create Hashmap for attributes
                        Map<String, Object> map = new HashMap<>();
                        //put data into attributes
                        map.put("name",name.getText().toString());
                        map.put("job",job.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("jurl",jurl.getText().toString());

                        //get Jobs table from Firebase Database
                        FirebaseDatabase.getInstance().getReference().child("Jobs")
                                //update attribute relative to map position
                                .child(getRef(holder.getAdapterPosition()).getKey()).updateChildren(map)
                                //on success of updated attribute
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        //display Toast message and dismiss
                                        Toast.makeText(holder.name.getContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                //on failure of update attribute
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //display Toast message and dismiss
                                        Toast.makeText(holder.name.getContext(), "Error While Updating...", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });

        //delete button OnClickListener
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pop up with an alert
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data can't be restored");

                //delete button set for removing data
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Jobs")
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();
                    }
                });

                //cancel button for cancelling delete
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

    }

    //returns a new ViewHolder
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item,parent,false);
        return new myViewHolder(view);
    }

    //initialise ViewHolder from the RecyclerView
    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView name,job,email;

        Button btnEdit,btnDelete;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.nameText);
            job = (TextView)itemView.findViewById(R.id.jobText);
            email = (TextView)itemView.findViewById(R.id.emailText);

            btnEdit = (Button)itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
        }


    }

}
