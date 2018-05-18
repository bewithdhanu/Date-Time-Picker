# Date Time Picker - Android

Date Time Picker library contains date picker and time picker, as well datetimepicker also.it is simple to use and very small sized library and free to use.

[![](https://jitpack.io/v/bewithdhanu/DateTimePicker.svg)](https://jitpack.io/#bewithdhanu/DateTimePicker)

Date Time Picker 
---- 
<img src="https://github.com/bewithdhanu/Date-Time-Picker/blob/master/ezgif-4-1af16ccb05.gif" data-canonical-src="https://github.com/bewithdhanu/Date-Time-Picker/blob/master/ezgif-4-1af16ccb05.gif" height="400" />

## Table of Contents
1. [Setup](#setup)
2. [Using Date Time Picker](#using-date-time-picker)
3. [MIT License](#mit-license)


## Setup
 The easiest way to add the Material DateTime Picker library to your project is by adding it as a dependency to your `build.gradle`
Android Gradle:
To get this Date Time Picker into your build:
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.bewithdhanu:DateTimePicker:-SNAPSHOT'
	}
  
  Maven:
Add the JitPack repository to your build file

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.bewithdhanu</groupId>
	    <artifactId>DateTimePicker</artifactId>
	    <version>-SNAPSHOT</version>
	</dependency>


## Using Date Time Picker
The library doesn't use much complex listeners and actions simple we can use it as EditText and we can use all properties of EditText
Here is the sample implemenation of Date Time Picker XML attribute
```
<in.mjtech.libraries.DateTimePicker
    android:id="@+id/editText3"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    customAttribute:format="time" />
```
customAttribute:format have 3 values **datetime**, **date**, **time**

And you can retrive date from this as same as EditText 
```
DateTimePicker dateTimePicker = findViewById(R.id.editText3);
String datetime=dateTimePicker.getText().toString();
```
And you have some extra features

| Method | Description |
| --- | --- |
| `String getDate(String format)` | Returns the String date in the format,that you sent as parameter of selected date |
| `Date getDate()` | Returns Date object of selected date |

## MIT License

Copyright (c) 2018 Dhanu K Parvateesam

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
