import React, { Component } from "react";
import { graphql } from "react-apollo";
import { hashHistory } from "react-router";

import currentUserQuery from "../queries/CurrentUser";

export default (WrappedComponent) => {
  class RequireAuth extends Component {
    componentWillUpdate(nextProps) {
      console.log("*******************");
      console.log("Checking AUTH");
      console.log(nextProps.data);
      console.log("*******************");

      if (!nextProps.data.loading && !nextProps.data.user) {
        console.log("PUSHING TO /login");
        hashHistory.push("/login");
      }
    }

    render() {
      return <WrappedComponent {...this.props} />;
    }
  }

  return graphql(currentUserQuery)(RequireAuth);
};
