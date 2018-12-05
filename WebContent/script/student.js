function loginCheck() {
	if(document.frm.stu_id.value.length == 0) {
		alert("아이디를 입력하세요");
		frm.stu_id.focus();
		return false;
	}
	if(document.frm.stu_pw.value == "") {
		alert("암호를 입력하세요");
		frm.stu_pw.focus();
		return false;
	}
	return true;
}