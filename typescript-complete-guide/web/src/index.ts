import { User } from "./models/User";

const user = User.buildUser({ id: 1, name: "Alice", age: 20 });

user.on("change", () => {
  console.log("*******************");
  console.log("user", user);
  console.log("*******************");
});

user.fetch();
