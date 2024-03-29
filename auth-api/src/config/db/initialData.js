import bcrypt from "bcrypt";
import User from "../../modules/user/model/User.js";

export async function createInitialData() {
    try {

        await User.sync({ force: true });

        let password = await bcrypt.hash("123456", 10);

        await User.create({
            name: "User Teste1",
            email: "userteste1@mail.com",
            password: password,
        });

        await User.create({
            name: "User Teste2",
            email: "userteste2@mail.com",
            password: password,
        });
        
    } catch (error) {
        console.error(error.message);
    }    
}