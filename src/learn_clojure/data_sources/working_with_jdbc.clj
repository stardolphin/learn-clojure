(ns learn-clojure.working-with-jdbc
  (:require
    [clojure.java.jdbc :as db]
    [jdbc.pool.c3p0 :as pool]
    ))

(def my-db {:subprotocol "postgresql"
            :subname     "//127.0.0.1:5432/clojure_test"
            :user        "michael"
            :password    "michael"
            })

(def my-pool (pool/make-datasource-spec my-db))

;; (db/execute! my-pool ["DROP TABLE IF EXISTS employees"])

;(db/execute! my-pool ["CREATE TABLE employees (
;  id serial PRIMARY KEY,
;  name text,
;  email text)"])

;(db/execute! my-pool
;             ["INSERT INTO employees (name, email) VALUES (?,?)"
;              "Tucker" "tucker@doggo.bone"])
; (db/insert! my-pool "employees" {:name "Timber" :email "timber@bighouse.com"})
; (db/insert! my-pool "employees" ["name" "email"] ["Hogie Carmichael" "stardust@song.com"])

(db/query my-pool ["SELECT * FROM employees WHERE id=? LIMIT 1" 13])

;; With Transaction will only complete if all transactions complete
(db/with-db-transaction [txn my-pool]
                        (db/delete! txn "employees" ["id=1"])
                        (db/delete! txn "employees" ["name=asdfasdf"])
                        )

