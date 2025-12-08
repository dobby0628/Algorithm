select concat("/home/grep/src/", m.max_board_id, "/",f.file_id, f.file_name, f.file_ext) as FILE_PATH
from USED_GOODS_FILE as f
join (
    select a.board_id as max_board_id
    from USED_GOODS_BOARD as a
    join (select max(views) as max from USED_GOODS_BOARD) as b
    on a.views = b.max
    ) as m
on f.board_id = m.max_board_id
order by f.file_id desc;