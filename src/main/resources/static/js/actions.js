function showAlert(){
    alert("kekw");
}

function deleteColumns(){
    let table = document.getElementById("data");
    if (table == undefined) return;
    let rowNum= table.rows.length;
    for(let i=1;i<rowNum;i++){
        if(table.rows[i].cells.item(1).innerHTML=="x") {
            table.deleteRow(i)
            rowNum--;
        }
    }
}