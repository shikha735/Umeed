function validate()
{
	var n=reg.nm.value;
	var p=reg.pwd.value;
	var cp=reg.cpwd.value
	var e=reg.eid.value;
	var phno=reg.contact.value;
	var i=reg.idno.value;

	if(n==""||n==null){
		alert("Enter full name");
		return false;
	}
	else if(!nval(n)){
		alert("Enter valid full name");
		return false;
	}
	else if(e==""||e==null){
		alert("Enter email id");
		return false;
	}
	else if(!eidval(e)){
		alert("Enter valid email id");
		return false;
	}
	else if(phno==""||phno==null){
		alert("Enter phone number");
		return false;
	}
	else if(!phnoval(phno)){
		alert("Enter valid phone number");
		return false;
	}
	else if(p==""||p==null){
		alert("Enter password");
		return false;
	}
	else if(!pval(p)){
		alert("Enter valid password");
		return false;
	}
	else if(p.localeCompare(cp)){
		alert("Enter correct password");
		return false;
	}
	else if(!ival(i)){
		alert("eneter valid ID No");
		return false;
	}
	else 
		return true;
}
function nval(n)
{
	var npat=/^[a-zA-Z]+$/;
	return npat.test(n);
}
function pval(p)
{
	var ppat=/^[a-zA-Z0-9]{6,15}$/;
	return ppat.test(p);
}
function eidval(e)
{
	var epat=/^[a-zA-Z0-9_.]+@([a-zA-Z0-9]+.)+[a-zA-Z]{2,4}$/;
	return epat.test(e);
}
function phnoval(phno)
{
	var phpat=/^[0-9]{10}$/;
	return phpat.test(phno);
}
function ival(i)
{
	var ipat=/^[A-Z]{3}-AD-[0-9]{4}$/;
	return ipat.test(i);
}