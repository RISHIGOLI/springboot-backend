import axios from "axios";

// export const BASE_URL="http://rideezy-env.eba-ipiwpram.ap-south-1.elasticbeanstalk.com";
export const BASE_URL="http://localhost:5000";

export const myAxios=axios.create({
    baseURL:BASE_URL
});
