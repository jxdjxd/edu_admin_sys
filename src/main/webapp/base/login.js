$(function () {
    $("input#submit").click(function () {

        const userName = $("input#userName").val();
        const password = $("input#password").val();
        const code = $("input#VarCode").val().toLowerCase();

        reg_userName = /^[a-z0-9A-Z\u2E80-\u9FFF_-]{1,10}$/;
        reg_password = /^[a-z0-9A-Z]{6,10}$/;
        reg_email = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

        if (userName.length > 10) {
            alert("�û����ַ����Ȳ��ܴ���10��");
            return false;
        }

        if (!reg_userName.test(userName)) {
            alert("�û���ֻ�ܰ������ġ�Ӣ���ַ������֡�-��_");
            return false;
        }

        if (password.length > 10 || password.length < 6) {
            alert("����ӦΪ6-10���ַ�");
            return false;
        }

        if (!reg_password.test(password)) {
            alert("����ֻ�ܰ���Ӣ���ַ������֡�-��_");
            return false;
        }

        if (code !== Relcode) {
            alert("��֤�벻��ȷ��");
            changeVarCode();
            return false;
        }

    });

    // �������֤��ͼƬʱ���л���֤��
    $("#code_img").click(changeVarCode);
});

function changeVarCode(){
    console.log("�����");
    const codeImg = $("#code_img");
    const src = jQuery(codeImg).attr("src");
    jQuery(codeImg).attr("src", chgUrl(src));
    return 0;
}

// ʱ���
// Ϊ��ʹÿ������ͼƬ��һ�£�����������������棬������Ҫ����ʱ���
function chgUrl(url) {
    const timestamp = (new Date()).valueOf();
    url = String(url);
    if(url.indexOf("?timestamp=") !== -1){
        url = url.substring(0, url.indexOf("?timestamp=")+12);
        url = url + timestamp;
    }else{
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}