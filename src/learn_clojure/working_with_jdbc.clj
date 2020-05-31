(ns learn-clojure.working-with-jdbc
  (:require
    [clojure.java.jdbc :as db]
    [jdbc.pool.c3p0    :as pool]
    ))
(def my-db {:subprotocol "postgresql"
            :subname "//127.0.0.1:5432/clojure_test"
            :user "michael"
            :password "michael"
            })
(def my-pool (pool/make-datasource-spec my-db))

(db/execute! my-pool ["DROP TABLE IF EXISTS employees"])

