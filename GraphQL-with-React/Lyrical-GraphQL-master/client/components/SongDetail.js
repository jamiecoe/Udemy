import React, { Component } from 'react'
import { graphql } from 'react-apollo'
import { Link } from 'react-router'

import fetchSingleSong from '../queries/fetchSingleSong'
import LyricCreate from './LyricCreate'
import LyricList from './LyricList'

class SongDetail extends Component {
  render() {
    if (this.props.data.loading) {
      return <h1>Loading...</h1>
    }

    const { song } = this.props.data
    return (
      <div>
        <Link to="/">Back</Link>
        <h3>{song.title}</h3>
        <LyricList lyrics={song.lyrics} />
        <LyricCreate songId={this.props.params.id} />
      </div>
    )
  }
}

export default graphql(fetchSingleSong, {
  options: props => ({ variables: { id: props.params.id } })
})(SongDetail)
