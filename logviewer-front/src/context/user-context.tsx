import React from "react";

export class User {
    username: string;
    authenticated: boolean;

    constructor(username: string, authenticated: boolean) {
        this.username = username;
        this.authenticated = authenticated;
    }
}

export const UserContext = React.createContext(new User("", false));
