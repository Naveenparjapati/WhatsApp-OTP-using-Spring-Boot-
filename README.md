# Springboot_with_whatsapp_api_integration Application development

## Pre-Requisites to develop this application
	-  Spring Boot
	-  Data JPA
	-  Web MVC
	-  REST API
	-  WhatsAPP Business Account (WATI)

## Development procedure

1) Create WATI account (7 days free trial available)		

2) Create Template in wati to send a otp msg like below

```Greetings for the day..!
Your OTP is *{{otp}}*
Thanks,
Navven 	
```

*Note: WATI will review our template and they will approve it. Once template got approved then only we can send a msg using that template.*

3) Configure WATI API Token & WATI Endpoint in our application

4) Use RestTemplate/Webclient to send msg to whatsapp using WATI API


## Application Execution Flow

1) Customer will fill registration form and will click on submit

2) Capture form data given by the customer 

3) Generate OTP using java method

4) Set Generated OTP and Account Status as "Not_verified" to customer object and Insert customer record in database table

5) Send OTP msg to customer given whatsapp number using wati api
			- prepare api request object
			- use wati api token as Authorization Header
			- send post request with token + request object
   

6) After sending whatsapp msg, redirect customer to validate OTP page and ask customer to enter OTP

7) Customer will enter OTP and will submit the form for validation

8) Take form data and verify customer record presence our database table with customer given email and otp. 

	- With given details if record available in DB that means it is valid otp then update account status as 'verified' and display success msg

	- with given details if record is not available in DB that means it is invalid otp so display error msg

	
