$(document).ready(function(){
	$.ajax({
		url : '/testdata',
		method : 'GET'
	}).then(function(testData) {
		for (var i = 0; i < testData.length; i++) {
			var data = testData[i];
			var row = "<tr><td>" + data.id + "</td><td>"
					+ data.data1 + "</td></tr>"; 
			$("#result").append(row);
		}
		console.log(testData);
	});
});