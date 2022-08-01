var main = {
    init : function () {
        var _this = this;
        $('#btn-auth').on('click', function () {
            _this.auth();
        });
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    auth : function () {
        var data = {
            name: $('#name').val(),
            phoneNumber: $('#phoneNumber').val()
        };

        $.ajax({
            type: 'POST',
            url: '/user/auth',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function(response) {
            if (response == -1) {
                alert('잘못된 접근입니다.')
            } else if (response == 0) {
                alert('창신 청년부 인증 성공.')
            } else if (response == 1) {
                alert('창신 청년부 인증에 실패했습니다!!')
            } else if (response == 2) {
                alert('이미 가입된 이름입니다.')
            }
        }).fail(function(error) {
            alert('알 수 없는 오류가 발생했습니다.\n관리자에게 문의 바랍니다.')
        });
    },
    save : function () {
        var data = {
            name: $('#name').val(),
            phoneNumber: $('#phoneNumber').val(),
            loginId: $('#loginId').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/user/save',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function(response) {
            if (response == -1) {
                alert('잘못된 접근입니다.')
            } else if (response == 0) {
                alert('회원 가입이 완료되었습니다!')
                window.location.href='/';
            } else if (response == 1) {
                alert('창신 청년부 인증에 실패했습니다!!')
            } else if (response == 2) {
                alert('이미 가입된 이름입니다.')
            }
        }).fail(function(error) {
            alert('알 수 없는 오류가 발생했습니다.\n관리자에게 문의 바랍니다.')
        });
    }
};

main.init();