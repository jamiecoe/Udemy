import React, { Component } from "react";
// Redux form allows you to validate and submit form data in a redux friendly way
// reduxForm is very similar to connect() function, it allows this component to communicate with the formReducer
import { Field, reduxForm } from "redux-form";
import { Link } from "react-router-dom";
import { connect } from "react-redux";
// import our action creator
import { createPost } from "../actions";

class PostsNew extends Component {
  // This is the function that will return JSX for Field component
  // It comes with a field arguement, which contains some event listeners which we need to wire up to the JSX we are returning
  renderField(field) {
    // error contains any error messages related to that specific input
    // this is why the error properties had to match the name of the field in validate() method

    // 3 different states for a field - pristine / touched / invalid
    // pristine - no input inside and user hasn't touched it (default state)
    // touched - user has focused into the input, then focused out
    // invalid - the validation has failed for that field
    const { meta: { touched, error } } = field;
    const className = `form-group ${touched && error ? "has-danger" : ""}`;

    // the {...field.input} adds all the event listeners etc from Field
    return (
      <div className={className}>
        <label>{field.label}</label>
        <input className="form-control" type="text" {...field.input} />
        <div className="text-help">
          {touched ? error : ""}
        </div>
      </div>
    );
  }

  // this is function called when the form is submitted
  // 'values' contains all our form values
  onSubmit(values) {
    // call the action creator, passing in values and a callback function
    this.props.createPost(values, () => {
      this.props.history.push("/");
    });
  }

  render() {
    // handleSubmit is added to props by reduxForm
    const { handleSubmit } = this.props;
    // For each input field in a form, create a Field component
    // ReduxForm automatically makes these controlled components (eg: value set by state)
    // name property in Field will specify which piece of state this Field will produce
    // Field is hooked up to ReduxForm, but it doesn't know how to show JSX (ie: HTML) to show an input on screen
    // Therefore, we pass a function into 'component' attribute which will return some amount of JSX which can be displayed
    // 'label' is an abritrary property that we can pass through to the jsx as a property on 'field'

    // We give a function (this.onSubmit) to handleSubmit
    // It will first check our validation stuff, then if successful it will call our function
    return (
      <form onSubmit={handleSubmit(this.onSubmit.bind(this))}>
        <Field
          label="Title For Post"
          name="title"
          component={this.renderField}
        />
        <Field
          label="Categories"
          name="categories"
          component={this.renderField}
        />
        <Field
          label="Post Content"
          name="content"
          component={this.renderField}
        />
        <button type="submit" className="btn btn-primary">Submit</button>
        <Link to="/" className="btn btn-danger">Cancel</Link>
      </form>
    );
  }
}

// seperate helper function for validation
// 'values' is an object that contains all form values entered by a user
function validate(values) {
  // console.log(values) -> { title: 'asdf', categories: 'asdf', content: 'asdf' }
  const errors = {};

  // Validate the inputs from 'values'
  // Properties on error need to match the 'name' attribute given for Field components!!
  if (!values.title) {
    errors.title = "Enter a title";
  }
  if (!values.categories) {
    errors.categories = "Enter some categories";
  }
  if (!values.content) {
    errors.content = "Enter some content please";
  }

  // If errors is empty, the form is fine to submit
  // If errors has *any* properties, redux form assumes form is invalid
  return errors;
}

// Pass in configuration options to reduxForm()
// 'PostsNewForm' is the name of the form, allows you to use multiple forms on same page. The name must be unique so that it doesn't accidently share its state with any other forms
// We pass in 'validate' helper function
// Redux will call 'validate' automatically for us at certain points during the form's lifecycle - eg: whenever the user trys to submit the form
// reduxForm will add a number of props to PostsNew, including handleSubmit()

// remember that connect is the bit that hooks up reducers and action creators to this component (eg: making them available on this.props)
// we're not using a reducer here so connect()'s first arguement is null, the second is that shortcut way of passing in the action creator (eg: just pass it in inside an object)
// in order to combine the reduxForm() and connect() helpers, we pass in the connect() bit as the 2nd arguemnt to reduxForm
export default reduxForm({
  validate,
  form: "PostsNewForm"
})(connect(null, { createPost })(PostsNew));
