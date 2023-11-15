-- 코드를 입력하세요
-- select date_format(created_date,"%Y-%m-%d") from USED_GOODS_REPLY

SELECT board.title, board.board_id,reply.reply_id,reply.writer_id,reply.contents,date_format(reply.created_date,"%Y-%m-%d") from
USED_GOODS_BOARD board join USED_GOODS_REPLY reply
on board.board_id = reply.board_id
where board.created_date like "2022-10-%"
order by reply.created_date,board.title
