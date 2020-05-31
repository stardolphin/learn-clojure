(defproject learning-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/data.csv "1.0.0"]
                 [org.clojure/core.async "1.2.603"]
                 [org.postgresql/postgresql "9.4-1200-jdbc41"]
                 [org.clojure/java.jdbc "0.3.6"]
                 [clojure.jdbc/clojure.jdbc-c3p0 "0.3.1"]
                 ]
  :main ^:skip-aot learning-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  )
