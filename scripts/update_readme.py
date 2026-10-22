
from pathlib import Path
from urllib.parse import quote
import re

ROOT = Path(__file__).resolve().parent.parent
SOLUTIONS_ROOT = ROOT / "Data Structures & Algorithms"
README = ROOT / "README.md"

EXTENSIONS = {
    ".py": "Python",
    ".js": "JavaScript",
    ".ts": "TypeScript",
    ".java": "Java",
    ".cpp": "C++",
    ".cs": "C#",
    ".go": "Go",
    ".rs": "Rust",
    ".kt": "Kotlin",
    ".swift": "Swift",
    ".sql": "SQL",
}

START = "<!-- NEETCODE:START -->"
END = "<!-- NEETCODE:END -->"


def prettify(text):
    return re.sub(r"[-_]+", " ", text).title()


def collect_problems():
    if not SOLUTIONS_ROOT.is_dir():
        raise FileNotFoundError(
            f"Folder not found: {SOLUTIONS_ROOT}"
        )

    problems = {}

    for file in SOLUTIONS_ROOT.rglob("submission-*"):
        if not file.is_file():
            continue

        if file.suffix.lower() not in EXTENSIONS:
            continue

        problem_dir = file.parent
        relative = problem_dir.relative_to(SOLUTIONS_ROOT)
        parts = relative.parts

        if not parts:
            continue

        # Supports both:
        # root/problem/submission-0.py
        # root/topic/problem/submission-0.py
        if len(parts) == 1:
            topic = "Data Structures & Algorithms"
        else:
            topic = prettify(parts[0])

        key = relative.as_posix()

        if key not in problems:
            problems[key] = {
                "name": prettify(problem_dir.name),
                "topic": topic,
                "path": problem_dir,
                "languages": set(),
            }

        problems[key]["languages"].add(
            EXTENSIONS[file.suffix.lower()]
        )

    return sorted(
        problems.values(),
        key=lambda p: (p["topic"].lower(), p["name"].lower()),
    )



def generate_section(problems):
    target = 150
    solved = len(problems)
    topics = sorted({p["topic"] for p in problems})
    progress = min(100, round(solved / target * 100))
    filled = round(progress / 100 * 20)
    bar = "█" * filled + "░" * (20 - filled)

    lines = [
        '<div align="center">',
        "",
        "# NeetCode Solutions",
        "",
        "### Data Structures & Algorithms",
        "",
        "My coding interview preparation journey.",
        "",
        f'<img src="https://img.shields.io/badge/NeetCode-150-0ea5e9?style=for-the-badge" alt="NeetCode 150">',
        f'<img src="https://img.shields.io/badge/Solutions-{solved}-22c55e?style=for-the-badge" alt="Solutions">',
        f'<img src="https://img.shields.io/badge/Topics-{len(topics)}-8b5cf6?style=for-the-badge" alt="Topics">',
        "",
        "</div>",
        "",
        "---",
        "",
        "## 📊 Progress Overview",
        "",
        "| Metric | Progress |",
        "|:--|--:|",
        f"| Problems solved | **{solved} / {target}** |",
        f"| Completion | **{progress}%** |",
        f"| Topics practiced | **{len(topics)}** |",
        "",
        f"`{bar}` **{progress}%**",
        "",
        "> Progress is generated automatically from the solution files in this repository.",
        "",
        "---",
        "",
        "## 🧠 Problem Solutions",
        "",
        "Browse the solutions by topic. Select a solution to view its source files.",
        "",
        "## 📚 Table of Contents",
        "",
    ]

    for i, topic in enumerate(topics, start=1):
        count = sum(p["topic"] == topic for p in problems)
        anchor = re.sub(r"[^a-z0-9 -]", "", topic.lower())
        anchor = re.sub(r"\s+", "-", anchor.strip())
        lines.append(
            f"{i}. [{topic}](#{anchor}) — **{count} problems**"
        )

    lines.extend(["", "---", ""])

    for topic in topics:
        group = [p for p in problems if p["topic"] == topic]
        lines.extend([
            f"## {topic}",
            "",
            f"**{len(group)} problems solved**",
            "",
            "| # | Problem | Language | Source |",
            "|--:|:--|:--|:--|",
        ])

        for i, problem in enumerate(group, start=1):
            path = quote(
                problem["path"].relative_to(ROOT).as_posix(),
                safe="/",
            )
            languages = ", ".join(sorted(problem["languages"]))
            lines.append(
                f"| {i} | {problem['name']} | {languages} "
                f"| [View code ↗]({path}/) |"
            )

        lines.append("")

    lines.extend([
        "---",
        "",
        "## 🛠️ Repository Structure",
        "",
        "```text",
        "Data Structures & Algorithms/",
        "├── Topic/",
        "│   └── Problem/",
        "│       └── submission-0.ext",
        "scripts/",
        "└── update_readme.py",
        ".github/",
        "└── workflows/",
        "    └── update-readme.yml",
        "```",
        "",
        "## 🔄 Automatic Updates",
        "",
        "- Solutions are organized by topic and problem.",
        "- GitHub Actions regenerates this README when solution files change.",
        "- Multiple submissions for one problem are counted as one problem.",
        "",
        "<div align=\"center\">",
        "",
        "Made with 💻 and consistency.",
        "",
        "</div>",
        "",
    ])

    return "\n".join(lines).rstrip()



def main():
    if not README.is_file():
        raise FileNotFoundError("README.md not found")

    readme = README.read_text(encoding="utf-8")
    problems = collect_problems()
    section = generate_section(problems)

    if START in readme and END in readme:
        pattern = re.compile(
            re.escape(START) + r".*?" + re.escape(END),
            re.DOTALL,
        )
        replacement = f"{START}\n{section}\n{END}"
        updated = pattern.sub(
            lambda _: replacement, readme, count=1
        )
    else:
        updated = (
            readme.rstrip()
            + "\n\n"
            + START
            + "\n"
            + section
            + "\n"
            + END
            + "\n"
        )

    if updated != readme:
        README.write_text(updated, encoding="utf-8")
        print(f"README updated: {len(problems)} problems")
    else:
        print("README is already up to date.")


if __name__ == "__main__":
    main()
