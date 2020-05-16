(ns learn-clojure.refs-and-agents)


(def acct1 (ref 1000 :validator #(>= % 0)))
(def acct2 (ref 1000 :validator #(>= % 0)))

(defn transfer [from-account to-account amount]
  (dosync (alter to-account + amount)
          (alter from-account - amount)))

(dotimes [_ 1000] (future (transfer acct2 acct1 100)))

@acct1
@acct2
;;
;; => nil
;; => 2000
;; => 0
