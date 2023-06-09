(ns letras.palavras 
    (:gen-class) 
    (:require 
        [clojure.string :as str]
        [letras.arvore :refer :all]
        ))

(defn pegaPalavras [letra] 
    (filter 
        #(> (count %) 0) 
        (map
            #(-> %
                (str/replace #"[^a-zA-Z]" "")
                (str/lower-case))
            (str/split letra #"\s"))))




