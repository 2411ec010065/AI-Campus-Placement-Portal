import { BrowserRouter, Routes, Route } from "react-router-dom";

import RecruiterDashboard from "./pages/recruiter/RecruiterDashboard";
import PostDrive from "./pages/recruiter/PostDrive";
import ManageDrives from "./pages/recruiter/ManageDrives";
import Applications from "./pages/recruiter/Applications";
import RecruiterProfile from "./pages/recruiter/RecruiterProfile";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<RecruiterDashboard />} />
        <Route path="/post-drive" element={<PostDrive />} />
        <Route path="/manage-drives" element={<ManageDrives />} />
        <Route path="/applications" element={<Applications />} />
        <Route path="/profile" element={<RecruiterProfile />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;