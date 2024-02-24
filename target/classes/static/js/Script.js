function FormSubmit(){
	var name = document.getElementById('name').value;
	var address = document.getElementById('address').value;
	var phone = document.getElementById('phone').value;
	var phone2 = document.getElementById('phone2').value;
	var quali = document.getElementById('quali').value;
	var aadharno = document.getElementById('aadharno').value;
	
	const inputEl = document.querySelector('#aadhar_input');
	const inputE2 = document.querySelector('#marksheet_input');
	const file1 = inputEl.files[0]; 
	const file2 = inputE2.files[0]; 
	
	 var returnvel = true;
	 
	 	
        if(name==""){
			seterror("requird field",0);
            returnvel = false;
			
		}else if(name.length<3||name.length>20)
        {
			seterror("length of name must be 3 to 20 characters",0);
            returnvel = false;
        }
        
        
        if(address==""){
			seterror("requird field",1);
            returnvel = false;
			
		}else if(address.length<5||address.length>30)
        {
			seterror("length of address must be 10 to 30 characters",1);
            returnvel = false;
        }
        
        
        if(phone==""){
			seterror("requird field",2);
            returnvel = false;
			
		}else if(phone.length<10||phone.length>12)
        {
			seterror("length of phone number must be 10 to 12 characters",2);
            returnvel = false;
        }
        
        
        if(phone2==""){
			seterror("requird field",3);
            returnvel = false;
			
		}else if(phone2.length<10||phone2.length>12)
        {
			seterror("length of phone number must be 10 to 12 characters",3);
            returnvel = false;
        }
        
        
        if(quali==""){
			seterror("requird field",4);
            returnvel = false;
			
		}else if(quali.length<3||quali.length>10)
        {
			seterror("length of Qualifications must be 3 to 20 characters",4);
            returnvel = false;
        }
        
        
        if(aadharno==""){
			seterror("requird field<br>",5);
            returnvel = false;
			
		}else if(aadharno.length!=12)
        {
			seterror("length of aadhar number must be 12 characters<br>",5);
            returnvel = false;
        }
        
        
        if(file1==null){
			seterror("plese choose a file<br>",6);
			console.log(file1)
            returnvel = false;
			
		}else if(file1.size>100000){
			seterror("file size must be les then 100kb<br>",6);
            returnvel = false;
		}
		
		if(file2==null){
			console.log(file2)
			seterror("plese choose a file<br>",7);
            returnvel = false;
			
		}else if(file2.size>100000){
			seterror("file size must be less then 100kb<br>",7);
            returnvel = false;
		}
        
          if(returnvel){
			  
			  document.getElementById('spn').innerHTML=`<div class="spinner ">
											<div class="spinner-border text-info" role="status">
  												<span class="sr-only"></span>
											</div>
										</div>`;
			 showSpinner();
			 hidebtn();
			
      		
     
      		setTimeout(function() {
        		hideSpinner();
        		showbtn();
        		
      			}, 10000);
			}
			
			console.log(returnvel);
			
			//if(returnvel)
				//return  paymentStart();
			//else
				return returnvel;
       

}


 




/* otp form js */


function otpFormSubmit(){
	

          
			  document.getElementById('spn').innerHTML=`<div class="spinner ">
											<div class="spinner-border text-info" role="status">
  												<span class="sr-only"></span>
											</div>
										</div>`;
			 showSpinner();
			 hidebtn();
			 
      		
     
      		setTimeout(function() {
        		hideSpinner();
        		showbtn();
        		
      			}, 60000);
			
			
	
}




/* Registration form js */


function RegistrationFormSubmit(){
	var Username = document.getElementById('username').value;
	var number = document.getElementById('number').value;
	var email = document.getElementById('email').value;
	var password = document.getElementById('password').value;
	

  

	 var returnvel = true;
	 
	 	
        if(Username==""){
			seterror("requird field",0);
            returnvel = false;
			
		}else if(Username.length<3||Username.length>20)
        {
			seterror("length of name must be 3 to 20 characters",0);
            returnvel = false;
        }
        
        
        
        if(number==""){
			seterror("requird field",1);
            returnvel = false;
			
		}else if(number.length!=10)
        {
			seterror("length of number must be 10 characters",1);
            returnvel = false;
        }
        
        
        if(email==""){
			seterror("requird field",2);
            returnvel = false;
			
		}
        
        
        if(password==""){
			seterror("requird field ",3);
            returnvel = false;
			
		}else if(password.length<6||password.length>10)
        {
			seterror("length of password must be 6 to 10 characters",3);
            returnvel = false;
        }
        
        
       
       
        
        
        
          if(returnvel){
			  
			  document.getElementById('spn').innerHTML=`<div class="spinner ">
											<div class="spinner-border text-info" role="status">
  												<span class="sr-only"></span>
											</div>
										</div>`;
			 showSpinner();
			 hidebtn();
			 
			// let body = document.querySelector("body");
			var Username1 = document.getElementById('username');
			 Username1.style.cursor="not-allowed";
      		
     
      		setTimeout(function() {
        		hideSpinner();
        		showbtn();
        		
      			}, 60000);
			}
			
			console.log(returnvel);
        return returnvel;

}



  
  
  
  
  
  /*------------------ */
  
  function seterror(error,classno){
        element = document.getElementById('formss');
        element.getElementsByClassName('formerror')[classno].innerHTML=error;
    } 
    

  function showSpinner() {
    document.querySelector(".spinner").style.display = "block";
  }

  function hideSpinner() {
    document.querySelector(".spinner").style.display = "none";
  }
  
  
   function showbtn() {
    document.querySelector("#btn").style.display = "block";
  }

  function hidebtn() {
    document.querySelector("#btn").style.display = "none";
  }
  
    