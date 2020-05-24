(ns learn-clojure.multimethods)

;; :language is the 'function' used to access which one
(defmulti hello :language)

;; the double colon implies membership of the namespace
;; this is the ::french version
(defmethod hello ::french [_] "Bonjour")
(defmethod hello ::english [_] "Hello")
(defmethod hello :default [_] "Yo")

(println (hello {:language ::french}))
(println (hello {:language ::english}))
(println (hello ::suomi))

(derive ::cockney ::english)
(println (hello {:language ::cockney}))

;; test relationship of functions. The following is true
(println (isa? ::cockney ::english))

