# Android Lab Week 7

1. Storage read/ write
2. SQLITE Insertion/Deletion/Updation
3. Load data from server


## 1. Storage read/write
You can find the file in app's folder named "myFile.txt"

## 2. SQLITE Insertion/Deletion/Updation 
At first add a contact by choosing a add new option in toolbar. 
You can edit the existing ones by clicking on it.

## 3. Load from server
For this I didn't use any PHP script or MYSQL DB, I made a endpoint via www.myjson.com which creates a json array as output.
https://api.myjson.com/bins/19xo2h

### For normal users
Here to modify your data use, myjson to create new end json array(Try to keep it as a array of strings as my Android Java code handles only that) and edit the end point address specified in ApiClient.java and ApiInterface.java.

Split the end point as I use,
https://api.myjson.com/bins/  part for the ApiClient.java
and
19xo2h/ part for the ApiInterface.java


### For Adavanced Users
I have used Retrofit library to Get Json and parse. If you want to modify the type of data displayed, use your own JSON and modify the Calling interface accordingly to get desired results.


Please don't tell the staff about the PHP and MYSQL parts, even if you wish to do it.


<b>P.S.: You can use www.heroku.com to deploy a PHP Server and MYSQL DB.</b>

