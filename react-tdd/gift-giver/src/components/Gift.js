import React, { Component } from 'react';
import { Form, FormGroup, FormControl, ControlLabel, Button } from 'react-bootstrap';

class Gift extends Component {
  constructor() {
    super();

    this.state = { person: '', present: '' };
  }

  render() {
    return (
      <div>
        <Form>
          <FormGroup>
            <ControlLabel>Person</ControlLabel>
            <FormControl 
              value={this.state.person}
              onChange={event => this.setState({ person: event.target.value })}
              className='input-person' 
            />
          </FormGroup>
          <FormGroup>
            <ControlLabel>Present</ControlLabel>
            <FormControl 
              value={this.state.present}
              onChange={event => this.setState({ present: event.target.value })}
              className='input-present' 
            />
          </FormGroup>
        </Form>
        <Button 
          className='btn-remove' 
          onClick={() => this.props.removeGift(this.props.gift.id)}
          >
          Remove Gift
        </Button>
      </div>
    )
  }
}

export default Gift;