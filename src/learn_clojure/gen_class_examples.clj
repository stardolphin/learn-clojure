(ns learn-clojure.gen-class-examples)

(gen-class :name learn_clojure.MyClass
           :prefix "my-"
           :methods [[getName [] String]]
           :constructors {[String] []}
           :state state
           :init init
           )

(defn my-init [name] [[] {:name name}])

(defn my-getName [this] "MyClass's name")
;; (import learn_clojure.MyClass)
(def get-the-name '(.getName (MyClass.)))

;; Need to do some magic of 'aot' ahead of time in the project file
(import learn_clojure.MyClass)
(.getName (MyClass.))
