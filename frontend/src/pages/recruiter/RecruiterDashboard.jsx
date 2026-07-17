import React from "react";
import { useNavigate } from "react-router-dom";

const RecruiterDashboard = () => {
  const navigate = useNavigate();

  return (
    <div style={{ padding: "20px" }}>
      <h1>Recruiter Dashboard</h1>
      <p>Welcome Recruiter!</p>

      <div style={{ marginTop: "20px" }}>
        <button onClick={() => navigate("/post-drive")}>
          Post New Drive
        </button>

        <button
          style={{ marginLeft: "10px" }}
          onClick={() => navigate("/manage-drives")}
        >
          Manage Drives
        </button>

        <button
          style={{ marginLeft: "10px" }}
          onClick={() => navigate("/applications")}
        >
          View Applications
        </button>

        <button
          style={{ marginLeft: "10px" }}
          onClick={() => navigate("/profile")}
        >
          Profile
        </button>
      </div>
    </div>
  );
}

export default RecruiterDashboard;