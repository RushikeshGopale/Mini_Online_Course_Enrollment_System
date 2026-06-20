function validateEmail() {
    let email = document.getElementById("email").value;
    let msg = document.getElementById("msg");

    if (email == "") {
        msg.innerHTML = "Enter email";
        msg.style.color = "red";
    }
    else if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
        msg.innerHTML = "Invalid email";
        msg.style.color = "red";
    }
    else {
        msg.innerHTML = "Valid email";
        msg.style.color = "green";
    }
}

//function to validate mobile no
function validatnum() {
	let num = document.getElementById("mnum").value;
	let mmsg = document.getElementById("mmsg");

	if (num == "") {
		mmsg.innerHTML = "Enter Mobile Number";
		mmsg.style.color = "red";
	}
	else if (num.length != 10) {
		mmsg.innerHTML = "Mobile number must be 10 digits";
		mmsg.style.color = "red";
	}
	else {
		mmsg.innerHTML = "Valid Mobile Number";
		mmsg.style.color = "green";
	}
}
function validatepass() {
    let pass = document.getElementById("pass").value;
    let passmsg = document.getElementById("passmsg");

    if (pass == "") {
        passmsg.innerHTML = "Enter password";
        passmsg.style.color = "red";
    }
    else if (pass.length < 6) {
        passmsg.innerHTML = "password must be a 6 character";
        passmsg.style.color = "red";
    }
    else {
        passmsg.innerHTML = "valid password";
        passmsg.style.color = "green";
    }

}

function validatuser()
{
    let email=document.getElementById("email").value.trim();
    let pass=document.getElementById("pass").value.trim();

    let valid=true;

    if(email=="")
    {
        document.getElementById("msg").style.display="block";
        valid=false;
    }
    else
    {
        document.getElementById("msg").style.display="none";
    }

    if(pass=="")
    {
        document.getElementById("passmsg").style.display="block";
        valid=false;
    }
    else
    {
        document.getElementById("passmsg").style.display="none";
    }

    return valid;
}

//for search Course
let searchCourse=(str)=>{
	let tableBody=document.getElementById("tbody");
	tableBody.innerHTML="";
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200)
			{
				tableBody.innerHTML=this.responseText;
			}
	};
	xhttp.open("GET","SearchCourseServlet?s="+ encodeURIComponent(str),true);
		xhttp.send();
}


let searchUserCourse = (str) => {
    let tableBody = document.getElementById("tbody");

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            tableBody.innerHTML = this.responseText;
        }
    };

    xhttp.open("GET", "SearchUserCourseServlet?s=" + encodeURIComponent(str), true);
    xhttp.send();
};

function enrollCourse(cid) {

    fetch("EnrollServlet?cid=" + cid)
        .then(res => res.text())
        .then(data => {
            if (data === "success") {

                alert("Enrollment Successful");
                loadUserCourses();

            } 
            else if (data === "exists") {
                alert("Already Enrolled");
            }
        });
}
function loadEnrollment() {
    fetch('ViewUserEnrollment')
        .then(res => res.text())
        .then(data => {
            document.getElementById("content-area").innerHTML = data;
        });
}

function loadAdminEnrollment() {
    fetch('ViewAllEnrollment')
        .then(res => res.text())
        .then(data => {
            document.getElementById("content-area").innerHTML = data;
        });
}


function loadProfile() {
    fetch('ViewProfileServlet')
        .then(res => res.text())
        .then(data => {
            document.getElementById("content-area").innerHTML = data;
        });
}

function updateProfile(event) {
    event.preventDefault();

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let pass = document.getElementById("pass").value;

    fetch("UpdateProfileServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "name=" + encodeURIComponent(name) +
              "&email=" + encodeURIComponent(email) +
              "&pass=" + encodeURIComponent(pass)
    })
    .then(res => res.text())
    .then(data => {

        if (data === "success") {
            alert("Profile Updated Successfully");
        } else {
            alert("Update Failed");
        }
    });
}

function loadUserCourses() {
    fetch('ViewAllUserCourse')
        .then(res => res.text())
        .then(data => {
            document.getElementById("content-area").innerHTML = data;
        });
}
//