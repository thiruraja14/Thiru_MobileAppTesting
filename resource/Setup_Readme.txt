
Setup:
1. Download Java and set Java_Home in environmental variables

2. Download Android STUDIO from this link: https://developer.android.com/studio#downloads

.exe file comes with 2 files as SDK and STUDIO 

3. Check Android installation path in Machine: Go to C\Users\ System Name(ex:Sarif)\ they type AppData. Hit Enter> AppData can be invisible mode. Click on Local folder. Click on Android folder. You will see sdk folder.

4.Set Android_Home environment variables path to SDK location: click on SDK folder. copy the path of that folder. Go to Advance System setting>Advance>Environment Variables>Click New>give variable name as “ANDROID_HOME” and past the path as variable value. Click on Ok. 

Then go back to SDK folder>tools>bin>copy the bin path>go back to environment variable>click on path>past the bin path>; copy and past tools path (ex: C:\Users\Sarif\AppData\Local\Android\Sdk\tools)> ; copy and past ‘platform-tools’ path(ex:C:\Users\Sarif\AppData\Local\Android\Sdk\platform-tools)

5.Open Android Studio and configuration virtual device/Emulator: Open Studio 64 or Android Studio from C:\Program Files\Android\Android Studio\bin. Then select ” Import Android Code Sample” ? Then choose any sample.  and click on next next until you reach on home window. From Tools select Device Manager’ or Search ‘AVD Manager’>+Create Virtual Device>Select the device (ex: pixel 3)>Next>Select the Android version (Make sure to Download the release first; ex: Pie) and complete the download version>click on Advance setting>Give AVD name (ex:Demo).>finish> click on launch to open the virtual mobile device.

6.Open Emulator and check if it is working or not:  Go to cmd> cd C:\Users\Sarif\AppData\Local\Android\Sdk\platform-tools (platform-tools path)> enter > then type emulator -avd <avd_emulator_name; ex:Demo>

7.Download Node.js from this link: https://nodejs.org/en/download/

Go the above link>click on 64 bit>finish the download and install .msi file 

8.Set Node_Home Environemental variables path: After you finish the installation, go to Program Files>open nodejs>copy the nodejs path(C:\Program Files\nodejs)>GO to environment variable>Create new variable name as ‘NODE_HOME’ and past the path as value 

9.Set npm Environment variables path:  Go to nodejs>node_modules>npm>bin>copy the path (ex: C:\Program Files\nodejs\node_modules\npm\bin) and past under path in environment variable.

10.Download Appium Server from Node using npm: go to cmd> type: npm install -g appium > hit enter>let extract and finish all the installation will say at the end ‘added packages from ….>After the installation done type: appium >hit enter> it will tell you the version number as ‘Welcome to Appium v2…+ Appium REST http interface Listener started on 0.0.0.0:4723 (port number).

Note: There are 2 parts of Appium as Client and Server. 

Client: we can write our Appium codes in multiple languages as Java, JavaScript, C#, Python, Rube. So we need specific jar/package/libraries  as per language we are going to use. Ex: Appium java client jar.

Server: We also need Appium Server to listen to our code from the client and execute as per request in Server and trigger in mobile devices (virtual).

npm: npm is command line tool or installer to install Appium. We can download any node module(Ex: Appium Server ) only using npm. 

To Uninstall Appium Server: npm uninstall -g appium

there is installer available for appium which can be found at

Note: https://github.com/appium/appium-desktop/releases/tag/v1.13.0

Note: Download Apk file : click on below button or go to: https://apkpure.com/ 

Download Apk files
11. Install and Open Eclipse and create a Maven Project (QuickStart template) with Appium client dependencies.

12. Understand and set the Desired Capabilities into the appium

13. Execute base/setup Appium program to invoke the Android apps.

Note:
1. Install appium inspector to find element path in app
    Note: Set correct device capabilities to start session
2. I have used eclpise for test development along with Maven plugin and testNG.
3. Make sure all system variables are configured properly or declare in test code itself 

TestNg:
1.TestNG helps to prioritize the test order : @Test(priority = 2)
2.TestNG helps specify the test order @Test(dependsOnMethods = "testMethodA")
3. You can use xml file for configuring the test order.
