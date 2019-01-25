function curry(a) {
    return function (b){
           return function (c) {
                return function (d) {
                    return function (e) {
                        return a+b+c+d+e;
                    }
                }
            }
        }
    }