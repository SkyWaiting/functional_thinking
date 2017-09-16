(ns com.nealford.functionalthinking.numberclassifier.core)

; BEGIN number_classifier_clojure
(defn is-factor? [factor number]                            ;<1>
  (zero? (rem number factor)))                              ;<2>

(defn factors [number]                                      ;<3>
  (filter #(is-factor? % number) (range 1 (inc number))))

(defn aliquot-sum [number]                                  ;<4>
  (- (reduce + (factors number)) number))

(defn perfect? [number]
  (= number (aliquot-sum number)))

(defn abundant? [number]
  (< number (aliquot-sum number)))

(defn deficient? [number]
  (> number (aliquot-sum number)))

; ENd number_classifier_clojure

; BEGIN 