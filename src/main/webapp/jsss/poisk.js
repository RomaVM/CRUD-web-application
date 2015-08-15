/**
 * Created by Mine on 19.04.2015.
 */
function Poisk() {
    // в p - что нужно искать в нижнем регистре
    var p = document.getElementById('poisk_text').value.toLowerCase();

    if (p.length === 0) return; // если ничего не было, то выход
    tbl = document.getElementById('clients');
    for (var i=1; i < tbl.rows.length; i++) {
        for (var j = 0; j < tbl.rows[i].cells.length; j++)	{
            var cur_cell = tbl.rows[i].cells[j];   // cur_cell - текуща¤ ¤чейка
            if (cur_cell.innerHTML.toLowerCase().indexOf(p) != -1)    // ищем в текущей ¤чейке искомое значение
            {
                cur_cell.style.backgroundColor="#80FF00";    // если найдено, то подсветим
            }
        }
    }
}