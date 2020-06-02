(ns learn-clojure.reading-and-writing-files)

(println (+ 1 1))

(def file-path-one "/home/michael/Sites/learn-clojure/spat.txt")

(println file-path-one)

(spit file-path-one (repeat 5 "HELLO!!!!!!"))

(println (count (slurp file-path-one)))

(require '[clojure.java.io :as io])

(def file-path-two "/home/michael/Sites/learn-clojure/forward")

(with-open [reader (io/reader file-path-two)
            writer (io/writer (str file-path-two ".out.txt"))]
  (doall
    (map #(.write writer (apply str (reverse %))) (line-seq reader))))

;; creates a file object
(println (io/file file-path-two))

;; slurp takes other arguments as well
;; send to REPL with ^x^e
(slurp "http://google.com")
