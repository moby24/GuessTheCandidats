#!/usr/bin/env bash
set -euo pipefail

TARGET_DIR="${1:-../test-project}"

mkdir -p "$TARGET_DIR"
cd "$TARGET_DIR"

if [ ! -d .git ]; then
  git init -b main
fi

cat > README.md <<'README'
# test-project

This is a lightweight test repository scaffolded from `GuessTheCandidats`.
README

cat > .gitignore <<'GITIGNORE'
.DS_Store
*.log
node_modules/
.env
GITIGNORE

if [ -z "$(git status --porcelain)" ]; then
  echo "Repository already initialized and clean: $TARGET_DIR"
  exit 0
fi

git add README.md .gitignore
if ! git rev-parse --verify HEAD >/dev/null 2>&1; then
  git commit -m "chore: initialize test-project repository"
else
  git commit -m "chore: update test-project scaffold"
fi

echo "Created or updated repository at: $TARGET_DIR"
