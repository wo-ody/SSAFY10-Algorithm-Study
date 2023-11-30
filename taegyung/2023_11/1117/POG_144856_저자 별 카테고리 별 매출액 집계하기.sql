-- 코드를 입력하세요
SELECT book.author_id, author.author_name, book.category, sum(book.price * sales.sales) total_sales
from book_sales sales join BOOK on sales.book_id = book.book_id
join AUTHOR on book.author_id = author.author_id
where sales_date like "2022-01%"

group by book.author_id , book.category

order by author_id, category desc
