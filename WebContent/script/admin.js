function loginCheck() {
	if(document.frm.ad_id.value.length == 0) {
		alert("아이디를 입력하세요");
		frm.ad_id.focus();
		return false;
	}
	if(document.frm.ad_pw.value == "") {
		alert("암호를 입력하세요");
		frm.ad_pw.focus();
		return false;
	}
	return true;
}