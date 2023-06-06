(ns letras.arvore (:gen-class))

(defn pega [m] (get m :valor))

(defn criaNo [valor] {:valor valor :count 0 :esquerda nil :direita nil})

(defn insere [novo raiz]
    (cond (nil? raiz) novo
        (< (compare (pega novo) (pega raiz)) 0) (assoc raiz :esquerda (insere novo (get raiz :esquerda)))
        (> (compare (pega novo) (pega raiz)) 0) (assoc raiz :direita (insere novo (get raiz :direita)))
        (= (compare (pega novo) (pega raiz)) 0) (assoc raiz :count (+ (get raiz :count) 1))
        :else raiz))

(defn gestaoInsere [raiz palavra] (insere (criaNo palavra) raiz))

(defn nilInt? [filho] (if (nil? filho) 0 1))

(defn qntFilhos [raiz] (+ (nilInt? (get raiz :esquerda)) (nilInt? (get raiz :direita))))

(defn folha? [raiz] (= (qntFilhos raiz) 0))

(defn show [raiz] "Apresenta infos do nó" (println (pega raiz) "-" "aparece" (get raiz :count) "vezes" "-" (qntFilhos raiz) "filhos") )

(defn preOrdem [raiz] 
    "Imprime a arvore em pre-ordem"
    (if (false? (nil? raiz)) 
        (do (show raiz)
            (preOrdem (get raiz :esquerda)) 
            (preOrdem (get raiz :direita)))))

(defn inOrdem [raiz]
    "Imprime a arvore em ordem"
    (if (false? (nil? raiz)) 
        (do (inOrdem (get raiz :esquerda))
            (show raiz)
            (inOrdem (get raiz :direita)))))

(defn posOrdem [raiz]
    "Imprime a arvore em pos-ordem"
    (if (false? (nil? raiz)) 
        (do (posOrdem (get raiz :esquerda)) 
            (posOrdem (get raiz :direita))
            (show raiz))))
    
(defn inOrdemReverse [raiz]
    "Imprime a arvore em ordem reversa"
    (if (false? (nil? raiz)) 
        (do (inOrdemReverse (get raiz :direita))
            (println (pega raiz)) 
            (inOrdemReverse (get raiz :esquerda)))))
