// 확장자 조회
function selectList() {
	$.ajax({
		type: 'get',
		url : '/check.do',
		dataType:'json',
		success: function(data){
            init(data);
		},
		error:function(){
			alert('조회실패');
		}
	})
}

// 화면 초기화
function init(data) {
	$('input[id^=def_chk]').prop('checked',false);
	$('#input_custom_ext').val('');
	$('#cnt_custom_ext').text(0);
	$('#div_custom_ext').empty();
	
	let custom_cnt = 0;
	let accept_ext = '';
	
	data.forEach((item) => {
		if(item.TYPE == 'D') {
			$('#def_chk_'+item.EXT).prop('checked',true);
		} else {
			let html = '';
			html += '<div id="cst_ext_'+item.EXT+'" style="display: inline-block; padding: 2px; margin: 3px; border: 1px solid #999; border-radius: 4px;">';
			html += '<span style="vertical-align: top;">'+item.EXT+'</span>';
			html += '<span id="del_'+item.EXT+'" OnClick="deleteExt(this)" class="material-symbols-outlined" style="cursor: pointer;">close</span>';
			html += '</div>';
			
			$('#div_custom_ext').append(html);
			custom_cnt++;
		}
		
		accept_ext += '.' + item.EXT + ',';
	})
	
	if(custom_cnt >= 200) $('#btn_add').attr('disabled', true);
	else $('#btn_add').attr('disabled', false);
	
	$('#cnt_custom_ext').text(custom_cnt);
	$('#input_file').attr('accept', accept_ext);
}

// 커스텀 확장자 삭제
function deleteExt(ext) {
	var param = {
		ext: $(ext).attr('id').split('_')[1]
	};

	$.ajax({
		type: 'post',
		url : '/del.do',
		headers: {'Content-Type': 'application/json'},
		data: JSON.stringify(param),
		success: function(data){
            selectList();
		},
		error:function(){
			alert('삭제실패');
		}
	})
}


$(document).ready(function() {
    selectList();
    
    // 고정 확장자 토글
    $('input[id^=def_chk]').change(function(){
        var param = {
        	ext: $(this).val()
        };
        
        if($(this).is(":checked")){
            param.useYn = 'Y';
        }else{
            param.useYn = 'N';
        }
        
        $.ajax({
			type: 'post',
			url : '/toggle.do',
			headers: {'Content-Type': 'application/json'},
			data: JSON.stringify(param),
			success: function(data){
	            selectList();
			},
			error:function(){
				alert('변경실패');
			}
		})
    });
    
    // 추가 버튼 동작
    $('#btn_add').on('click', function() {
    	var param = {
    		ext: $('#input_custom_ext').val().trim().replace(/ /gi, '')
    	};
    	
    	if (param.length == 0) return;
    
    	$.ajax({
			type: 'post',
			url : '/add.do',
			headers: {'Content-Type': 'application/json'},
			data: JSON.stringify(param),
			success: function(data){
	            if(data == 'OK') selectList();
	            else alert('이미 등록된 확장자입니다.');
			},
			error:function(){
				alert('등록실패');
			}
		})
    });
});