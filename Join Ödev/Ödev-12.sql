--film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan 
--fazla kaç tane film vardır?
--SELECT COUNT(length) FROM film
--WHERE length > ALL  (
--SELECT AVG(length) FROM film)

--film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?
--SELECT COUNT(rental_rate) FROM film
--WHERE rental_rate =  (
--SELECT MAX(rental_rate) FROM film)


--film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.
--SELECT title, rental_rate, replacement_cost FROM film
--WHERE (rental_rate =ALL (SELECT MIN(rental_rate) FROM film))
--AND (replacement_cost = ALL (SELECT MIN(replacement_cost)  FROM film))

--payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.
SELECT customer_id,COUNT(customer_id) FROM payment
GROUP BY customer_id
ORDER BY COUNT(customer_id) DESC

