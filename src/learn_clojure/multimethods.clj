(ns learn-clojure.multimethods)

;; :language is the 'function' used to access which one
(defmulti hello :language)

;; the double colon implies membership of the namespace
;; this is the ::french version
(defmethod hello ::french [_] "Bonjour")
(defmethod hello ::english [_] "Hello")

(println (hello {:language ::french}))
(println (hello {:language ::english}))

