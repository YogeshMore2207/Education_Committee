
//first request to server to create order 

const paymentStart=()=>{
	
	
	
	let amount =350;
    //let amount =$("#payment_field").val();
    //if(amount==''||amount==null){
     //   alert("amount is requird!!");
    //    return;
   // }
    console.log(amount);
    
    
    
    
     $.ajax(
        {
            url:'/user/create_order',
            data:JSON.stringify({amount:amount,info:'order_request'}),
            contentType:'application/json',
            type:'POST',
            dataType:'json',
            success:function(response){
                console.log(response)
                if(response.status=="created"){
					
					let options={
						key:"rzp_test_8tKV787nlzcAEY",
						amount:response.amount,
						currency:"INR",
						name:"Education Committee",
						description:"Addmision",
						image:"/images/logo.png",
						order_id:response.id,
						handler:function(response){
							paymentStatus();							
							console.log(response.razorpay_payment_id)
							console.log(response.razorpay_order_id)
							console.log(response.razorpay_signature)
							window.location.href = "http://localhost:8080/";
						},
						prefill: {
							name: "",
							email: "",
							contact: ""
						},
						notes: {
							"address": ""
						},
						theme: {
							color: "#3399cc"
						}
						
					};
					var rzp = new Razorpay(options);
					
					
					rzp.on('payment.failed', function (response){
						console.log(response.error.code);
						console.log(response.error.description);
						console.log(response.error.source);
						console.log(response.error.step);
						console.log(response.error.reason);
						console.log(response.error.metadata.order_id);
						console.log(response.error.metadata.payment_id);
					});
					
					var payment = rzp.open();
					console.log(payment);
				}
             },
             error:function(error){
				 //invoke when error
				 console.log(error)
				 console.log('something want wrong!')
			 }
         }
      )
    
    

    
    };
    
    
    
    
 function paymentStatus(){
	 
	 console.log("hello");
	 $.ajax(
        {
            url:'/user/paymentStatus',
            data:JSON.stringify({
				status:"done"
			}),
            contentType:'application/json',
            type:'POST',
            dataType:'json'
            });
 }   