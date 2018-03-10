import React from 'react';

const VideoDetail = ({ video }) => {

  // video will intially be undefined until YT api call comes back
  // We want to return a loading message until this happens
  // When the YT videos come back, this will cause the Parent component (and children) to rerender
  if(!video) return <div>Loading...</div>;

  const videoId = video.id.videoId;
  return (
    <div className="video-detail col-md-8">
      <div className="embed-responsive embed-responsive-16by9">
        <iframe className="embed-responsive-item" src={`https://youtube.com/embed/${videoId}`}/>
      </div>
      <div className="details">
        <div>{video.snippet.title}</div>
        <div>{video.snippet.description}</div>
      </div>
    </div>
  )
};

export default VideoDetail;
