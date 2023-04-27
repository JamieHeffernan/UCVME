# UCVME User Manual

## What Is The App About?

**UCVME is an app where users can create an account, upload a video of themselves on their profiles and either create a job or look for a person willing to do a job.**

**However this app is not a professional app like LinkedIn where professional jobs are listed. This app is simple and mainly for people looking to get small tasks done such as walking a dog etc. Or looking to do simple tasks for others!**

> “I like simplicity; I don’t need luxury.” ~ Eleanor Roosevelt

## Hardware Requirements
- Windows 10 or higher
- 2 GB of available disk space minimum, 4 GB Recommended
- Required Minimum Ram 4GB
- PC/Laptop
- An Internet Connection

## Installation Guide

**Step 1.**

You have to make sure you are connected to the Firebase Database when you try run this app otherwise you won't be able to Register or Login

To connect with our database access must be given to it therefore a gmail is required

Once this is done navigate to Tools>Firebase>Authentication and press Authenticate using a custom authentication system [Java]

Then a prompt window will open up for you to connect to the database make sure to pick UCVME database

***You are now connected to the database!***

**Step 2.**

**Make sure to install following dependencies if not already in the application:**

***These are located in UCVME/app/build.gradle inside "dependencies"***

```
 implementation 'androidx.appcompat:appcompat:1.6.1'
 implementation 'com.google.android.material:material:1.8.0'
 implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

 implementation 'com.google.firebase:firebase-database:20.1.0'
 implementation 'com.google.firebase:firebase-storage:20.1.0'
 implementation 'com.google.firebase:firebase-auth:21.2.0'
 implementation 'com.firebaseui:firebase-ui-database:7.1.1'

 implementation 'androidx.recyclerview:recyclerview:1.3.0'
 implementation 'androidx.cardview:cardview:1.0.0'
 implementation 'com.google.android.material:material:1.8.0'
 implementation 'de.hdodenhof:circleimageview:3.1.0'
 implementation 'com.squareup.picasso:picasso:2.5.2'
 implementation 'com.github.bumptech.glide:glide:4.15.1'
 implementation 'com.orhanobut:dialogplus:1.11@aar'
 implementation 'androidx.navigation:navigation-fragment:2.5.3'
 implementation 'androidx.navigation:navigation-ui:2.5.3'

 testImplementation 'junit:junit:4.13.2'
 androidTestImplementation 'androidx.test.ext:junit:1.1.5'
 androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
```

**Step 3.**

***In this step setup an emulator of an Android device to be able to run the app on a AVD (Android Virtual Device)***

Go to Device Manager located on the very right of your screen and click "Create Device"

Here I recommend choosing a Pixel 2 phone and click next, after choose API Oreo 26 and install it if not yet installed then press next

Once the AVD is installed you should be able to find it within Device Manager tab

**Step 4.**

To run the app simply press green triangle at the top of your screen beside the dropdown of the AVD you are using

Let the AVD run and install everything required for the app ***NOTE: this may take a while***

## How To Use The App

***Once you are in the application you will be greeted with a login screen***

Here you can either register a new user with an email and password or log into one of the existing users found in the Authentication tab in the Firebase Console. Press REGISTER and try this user: email:test3@gmail.com pass:123456 and press Log In

If information is correctly entered you should be logged in with no errors otherwise an error should display on the screen

**NOTE: you stay automatically logged into the app**

You will now be brought into the Main Menu of the app and here you have three options: Log Out, Browse Jobs and Edit Profile

The Browse Jobs page has a few notable features, firstly all jobs that have been listed can be seen on this page. Users image, email, job type and name are displayed here in a list. You can also either delete or edit job entries this user should be only user specific however we did not get to implement that as a feature. A user can also add a job entry with the plus button at the bottom right. Once done so a user has to enter relevant information and for the image use an image URL found online and pasted into the app. This will add the users job entry dynamically into the list

In the Edit Profile page, users can upload a video of themselves onto the application. To upload a video simply press the bottom right button and choose either camera or gallery. If choosing from the gallery make sure to drag a video into your gallery from your PC so that you can use it. Once that is done give the video a title and click upload. Once the video has been uploaded sucessfully you can click the video preview screen and play the video.

## How To Quit

The Logout button logs you out of the application and brings you back to the Login page from there simply press the red square at the top right of your task bar to turn of the device.

## License

MIT License

Copyright (c) 2023 JamieHeffo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Project By

**Krystian Pakos, Jamie Heffernan, Karla Lozer, Domen Zupancic, Michal Korneluk**


 
