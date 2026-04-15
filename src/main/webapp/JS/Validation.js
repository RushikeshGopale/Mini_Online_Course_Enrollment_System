function validateEmail()
{
	var email = document.getElementById("email").value;
	var msg = document.getElementById("msg");

	if (email == "") 
	{
		 msg.innerHTML = "Enter email";
	} 
	else if (email.indexOf("@") == -1 || email.indexOf(".") == -1)
	{
	     msg.innerHTML = "Invalid email";
	}
	else
	{
	    msg.innerHTML = "Valid email";
	}
}