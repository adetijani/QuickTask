SELECT T1.id, T1.name, T1.age
FROM T1
LEFT JOIN T2 ON T1.id = T2.id AND T1.name = T2.name AND T1.age = T2.age
WHERE T2.id IS NULL
ORDER BY T1.id ASC;  -- Added ORDER BY clause

