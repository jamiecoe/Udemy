import React from 'react';
import VideoListItem from './video_list_item';

// props is the data that's passed in by Parent component
// In a functional component, props is an arguement that's passed in
const VideoList = (props) => {

  // You need to give each VideoListItem a unique key, in this case we'll use the etag (unique code for each video)
  const videoItems = props.videos.map((video) => <VideoListItem
    onVideoSelect={props.onVideoSelect}
    key={video.etag}
    video={video}
  />);

  // React will recognise a variable which contains an array (eg: an array of VideoListItems) and render them all inside <ul>
  return (
    <ul className="col-md-4 list-group">
      {videoItems}
    </ul>
  );
};

export default VideoList;
