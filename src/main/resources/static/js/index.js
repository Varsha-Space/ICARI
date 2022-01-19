const confPaymentStart = () =>{
    console.log("Payment started!");
    var amount = $("#amount").val();
    console.log("amount = "+amount);

    $.ajax({
        url:"/createConfOrder",
        data:JSON.stringify({amount:amount}),
        contentType:"application/json",
        type:"POST",
        dataType:"json",
        success:function(response){
            console.log(response);
            if(response.status == "created")
            {
                var options = {
                    key: "rzp_test_EJZbjY3c7c2HlH", // Enter the Key ID generated from the Dashboard
                    amount: response.amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
                    currency: response.currency,
                    name: "ICARI",
                    description: "International Conference on Advanced Research and Innovation",
                    image: "https://www.freeiconspng.com/thumbs/payment-icon/cash-payment-icon-5.png",
                    order_id: response.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
                    handler: function (response){
                        console.log(response.razorpay_payment_id);
                        console.log(response.razorpay_order_id);
                        console.log(response.razorpay_signature);
                        console.log("Payment Successfull!");
                        alert("Congratulations! Payment Successful!");
                    },
                    prefill: {
                        name: $("#partName").val(),
                        email: $("#partEmail").val(),
                        contact: $("#partPhone").val()
                    },
                    notes: {
                        address: "ICARI"
                    },
                    theme: {
                        color: "#3399cc"
                    }
                };

                var rzp = new Razorpay(options);
                rzp.open();
                rzp.on('payment.failed', function (response){
                    console.log(response.error.code);
                    console.log(response.error.description);
                    console.log(response.error.source);
                    console.log(response.error.step);
                    console.log(response.error.reason);
                    console.log(response.error.metadata.order_id);
                    console.log(response.error.metadata.payment_id);
                    alert("Oops!! Payment failed!");
                });
            }
        },
        error:function(error) { 
            console.log(error);
            alert("Something went worng.")
        }
    });
}