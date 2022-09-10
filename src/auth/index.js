//isLoggedIn=> 
export const isLoggedIn=()=>{
    let data = localStorage.getItem("data");
    if(data!=null){
        return true;
    }

    else{
        return false;
    }
};

//doLogIn=> set data to localstorage
export const doLogIn=(data,next)=>{
    localStorage.setItem("data",JSON.stringify(data));
    next()
};

//doLogOut=> remove data from localstorage
export const doLogOut=(next)=>{
    localStorage.removeItem("data");
    next()
};

//get CurrentUser
export const getCurrentUserDetail=()=>{
    if(isLoggedIn()){
        return JSON.parse(localStorage.getItem("data"))?.data;
    }
    else {
        return undefined;
    }
};



