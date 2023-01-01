<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>[개발자 과제] 파일 확장자 차단</title>
	
	<script src="/resources/js/jquery-3.6.3.min.js"></script>
	<script type="text/javascript" src="/resources/js/index.js" ></script>
	
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<div style="display: block; margin-bottom: 5px;">
		<div style="float: left; width: 150px; font-weight: bold;">고정 확장자</div>
		<div>
			<input type="checkbox" id="def_chk_bat" value="bat"><label for="def_chk_bat">bat</label>
			<input type="checkbox" id="def_chk_cmd" value="cmd"><label for="def_chk_cmd">cmd</label>
			<input type="checkbox" id="def_chk_com" value="com"><label for="def_chk_cmd">com</label>
			<input type="checkbox" id="def_chk_cpl" value="cpl"><label for="def_chk_cmd">cpl</label>
			<input type="checkbox" id="def_chk_exe" value="exe"><label for="def_chk_cmd">exe</label>
			<input type="checkbox" id="def_chk_scr" value="scr"><label for="def_chk_cmd">scr</label>
			<input type="checkbox" id="def_chk_js" value="js"><label for="def_chk_cmd">js</label>
		</div>
	</div>
	
	<div style="display: block; margin-bottom: 5px;">
		<div style="float: left; width: 150px; height: 300px; font-weight: bold;">커스텀 확장자</div>
		<div>
			<input id="input_custom_ext" type="text" maxlength="20" style="width: 400px;" />
			<button id="btn_add"><span>+추가</span></button>
			<div style="width: 500px; height: 280px; overflow: scroll; border: 1px solid #999; border-radius: 4px; margin-top: 5px;">
				<div><span id="cnt_custom_ext">0</span>/200</div>
				<div id="div_custom_ext">
				</div>			
			</div>
		</div>
	</div>
	
	<div style="display: block;">
		<div style="float: left; width: 150px; height: 300px; font-weight: bold;">파일 선택</div>
		<div>
			<input type="file" id="input_file">
		</div>
	</div>
</body>
</html>
