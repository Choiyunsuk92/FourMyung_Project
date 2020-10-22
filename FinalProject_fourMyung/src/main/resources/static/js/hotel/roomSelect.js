$(function(){
	
	$("#checkDateIn").on("change", function(){
		$("#r_chek_In_Date").val($(this).val());
		$("#h_chek_In_Date").val($(this).val());
	});
	
	$("#checkDateOut").on("change", function(){
		$("#r_chek_Out_Date").val($(this).val());
		$("#h_chek_Out_Date").val($(this).val());
	});
})